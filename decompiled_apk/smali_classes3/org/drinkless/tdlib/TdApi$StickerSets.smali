.class public Lorg/drinkless/tdlib/TdApi$StickerSets;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StickerSets"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7048f24c


# instance fields
.field public sets:[Lorg/drinkless/tdlib/TdApi$StickerSetInfo;

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32728
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 32729
    return-void
.end method

.method public constructor <init>(I[Lorg/drinkless/tdlib/TdApi$StickerSetInfo;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "stickerSetInfoArr"    # [Lorg/drinkless/tdlib/TdApi$StickerSetInfo;

    .line 32718
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 32719
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$StickerSets;->totalCount:I

    .line 32720
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$StickerSets;->sets:[Lorg/drinkless/tdlib/TdApi$StickerSetInfo;

    .line 32721
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32725
    const v0, -0x7048f24c

    return v0
.end method
