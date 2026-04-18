.class public Lorg/drinkless/tdlib/TdApi$SetBio;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetBio"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6088dcac


# instance fields
.field public bio:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19446
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19447
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 19437
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19438
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetBio;->bio:Ljava/lang/String;

    .line 19439
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19443
    const v0, -0x6088dcac

    return v0
.end method
