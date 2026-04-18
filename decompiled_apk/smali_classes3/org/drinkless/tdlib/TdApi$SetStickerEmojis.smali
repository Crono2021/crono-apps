.class public Lorg/drinkless/tdlib/TdApi$SetStickerEmojis;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetStickerEmojis"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2613fbcf


# instance fields
.field public emojis:Ljava/lang/String;

.field public sticker:Lorg/drinkless/tdlib/TdApi$InputFile;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31908
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31909
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputFile;Ljava/lang/String;)V
    .locals 0
    .param p1, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;
    .param p2, "str"    # Ljava/lang/String;

    .line 31898
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31899
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetStickerEmojis;->sticker:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 31900
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SetStickerEmojis;->emojis:Ljava/lang/String;

    .line 31901
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31905
    const v0, -0x2613fbcf

    return v0
.end method
