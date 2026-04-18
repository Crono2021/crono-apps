.class public Lorg/drinkless/tdlib/TdApi$SearchStickerSets;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SearchStickerSets"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$StickerSets;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xfaa066c


# instance fields
.field public query:Ljava/lang/String;

.field public stickerType:Lorg/drinkless/tdlib/TdApi$StickerType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30708
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30709
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$StickerType;Ljava/lang/String;)V
    .locals 0
    .param p1, "stickerType"    # Lorg/drinkless/tdlib/TdApi$StickerType;
    .param p2, "str"    # Ljava/lang/String;

    .line 30698
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30699
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SearchStickerSets;->stickerType:Lorg/drinkless/tdlib/TdApi$StickerType;

    .line 30700
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SearchStickerSets;->query:Ljava/lang/String;

    .line 30701
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30705
    const v0, 0xfaa066c

    return v0
.end method
