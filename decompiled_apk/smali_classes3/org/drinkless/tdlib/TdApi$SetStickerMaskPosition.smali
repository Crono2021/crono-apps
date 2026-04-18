.class public Lorg/drinkless/tdlib/TdApi$SetStickerMaskPosition;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetStickerMaskPosition"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x47a959d0


# instance fields
.field public maskPosition:Lorg/drinkless/tdlib/TdApi$MaskPosition;

.field public sticker:Lorg/drinkless/tdlib/TdApi$InputFile;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31948
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31949
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputFile;Lorg/drinkless/tdlib/TdApi$MaskPosition;)V
    .locals 0
    .param p1, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;
    .param p2, "maskPosition"    # Lorg/drinkless/tdlib/TdApi$MaskPosition;

    .line 31938
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31939
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetStickerMaskPosition;->sticker:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 31940
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SetStickerMaskPosition;->maskPosition:Lorg/drinkless/tdlib/TdApi$MaskPosition;

    .line 31941
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31945
    const v0, 0x47a959d0    # 86707.625f

    return v0
.end method
