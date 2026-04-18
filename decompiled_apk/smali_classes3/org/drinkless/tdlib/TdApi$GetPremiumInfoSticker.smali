.class public Lorg/drinkless/tdlib/TdApi$GetPremiumInfoSticker;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetPremiumInfoSticker"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Sticker;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x79ce4a9b


# instance fields
.field public monthCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13308
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13309
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 13299
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13300
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$GetPremiumInfoSticker;->monthCount:I

    .line 13301
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13305
    const v0, 0x79ce4a9b

    return v0
.end method
