.class public Lorg/drinkless/tdlib/TdApi$GetArchivedStickerSets;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetArchivedStickerSets"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$StickerSets;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3bb8424d


# instance fields
.field public limit:I

.field public offsetStickerSetId:J

.field public stickerType:Lorg/drinkless/tdlib/TdApi$StickerType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37136
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37137
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$StickerType;JI)V
    .locals 0
    .param p1, "stickerType"    # Lorg/drinkless/tdlib/TdApi$StickerType;
    .param p2, "j5"    # J
    .param p4, "i9"    # I

    .line 37125
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37126
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetArchivedStickerSets;->stickerType:Lorg/drinkless/tdlib/TdApi$StickerType;

    .line 37127
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$GetArchivedStickerSets;->offsetStickerSetId:J

    .line 37128
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$GetArchivedStickerSets;->limit:I

    .line 37129
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37133
    const v0, 0x3bb8424d

    return v0
.end method
