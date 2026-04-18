.class public Lorg/drinkless/tdlib/TdApi$SetBusinessOpeningHours;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetBusinessOpeningHours"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1b8f5b8e


# instance fields
.field public openingHours:Lorg/drinkless/tdlib/TdApi$BusinessOpeningHours;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19554
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19555
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$BusinessOpeningHours;)V
    .locals 0
    .param p1, "businessOpeningHours"    # Lorg/drinkless/tdlib/TdApi$BusinessOpeningHours;

    .line 19545
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19546
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetBusinessOpeningHours;->openingHours:Lorg/drinkless/tdlib/TdApi$BusinessOpeningHours;

    .line 19547
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19551
    const v0, -0x1b8f5b8e

    return v0
.end method
