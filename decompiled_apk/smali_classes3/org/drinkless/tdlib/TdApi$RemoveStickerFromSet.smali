.class public Lorg/drinkless/tdlib/TdApi$RemoveStickerFromSet;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RemoveStickerFromSet"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x61e1eea4


# instance fields
.field public sticker:Lorg/drinkless/tdlib/TdApi$InputFile;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18636
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 18637
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputFile;)V
    .locals 0
    .param p1, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 18627
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 18628
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$RemoveStickerFromSet;->sticker:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 18629
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18633
    const v0, 0x61e1eea4

    return v0
.end method
