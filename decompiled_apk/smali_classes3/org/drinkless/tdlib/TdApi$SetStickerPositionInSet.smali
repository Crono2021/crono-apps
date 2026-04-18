.class public Lorg/drinkless/tdlib/TdApi$SetStickerPositionInSet;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetStickerPositionInSet"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7bb24721


# instance fields
.field public position:I

.field public sticker:Lorg/drinkless/tdlib/TdApi$InputFile;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31968
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31969
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputFile;I)V
    .locals 0
    .param p1, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;
    .param p2, "i9"    # I

    .line 31958
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31959
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetStickerPositionInSet;->sticker:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 31960
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$SetStickerPositionInSet;->position:I

    .line 31961
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31965
    const v0, 0x7bb24721

    return v0
.end method
