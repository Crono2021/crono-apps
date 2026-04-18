.class public Lorg/drinkless/tdlib/TdApi$SetDefaultMessageAutoDeleteTime;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetDefaultMessageAutoDeleteTime"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x69a32c94


# instance fields
.field public messageAutoDeleteTime:Lorg/drinkless/tdlib/TdApi$MessageAutoDeleteTime;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19662
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19663
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MessageAutoDeleteTime;)V
    .locals 0
    .param p1, "messageAutoDeleteTime"    # Lorg/drinkless/tdlib/TdApi$MessageAutoDeleteTime;

    .line 19653
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19654
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetDefaultMessageAutoDeleteTime;->messageAutoDeleteTime:Lorg/drinkless/tdlib/TdApi$MessageAutoDeleteTime;

    .line 19655
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19659
    const v0, -0x69a32c94

    return v0
.end method
