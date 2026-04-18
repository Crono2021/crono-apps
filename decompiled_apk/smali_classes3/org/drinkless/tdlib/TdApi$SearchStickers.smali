.class public Lorg/drinkless/tdlib/TdApi$SearchStickers;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SearchStickers"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Stickers;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6ea4cf62


# instance fields
.field public emojis:Ljava/lang/String;

.field public inputLanguageCodes:[Ljava/lang/String;

.field public limit:I

.field public offset:I

.field public query:Ljava/lang/String;

.field public stickerType:Lorg/drinkless/tdlib/TdApi$StickerType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50654
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 50655
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$StickerType;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;II)V
    .locals 0
    .param p1, "stickerType"    # Lorg/drinkless/tdlib/TdApi$StickerType;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "str2"    # Ljava/lang/String;
    .param p4, "strArr"    # [Ljava/lang/String;
    .param p5, "i9"    # I
    .param p6, "i10"    # I

    .line 50640
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 50641
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SearchStickers;->stickerType:Lorg/drinkless/tdlib/TdApi$StickerType;

    .line 50642
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SearchStickers;->emojis:Ljava/lang/String;

    .line 50643
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SearchStickers;->query:Ljava/lang/String;

    .line 50644
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SearchStickers;->inputLanguageCodes:[Ljava/lang/String;

    .line 50645
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$SearchStickers;->offset:I

    .line 50646
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$SearchStickers;->limit:I

    .line 50647
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50651
    const v0, -0x6ea4cf62

    return v0
.end method
