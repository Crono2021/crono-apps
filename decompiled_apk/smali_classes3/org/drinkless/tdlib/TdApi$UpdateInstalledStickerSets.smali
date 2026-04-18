.class public Lorg/drinkless/tdlib/TdApi$UpdateInstalledStickerSets;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateInstalledStickerSets"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x676b4896


# instance fields
.field public stickerSetIds:[J

.field public stickerType:Lorg/drinkless/tdlib/TdApi$StickerType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34588
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34589
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$StickerType;[J)V
    .locals 0
    .param p1, "stickerType"    # Lorg/drinkless/tdlib/TdApi$StickerType;
    .param p2, "jArr"    # [J

    .line 34578
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34579
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateInstalledStickerSets;->stickerType:Lorg/drinkless/tdlib/TdApi$StickerType;

    .line 34580
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateInstalledStickerSets;->stickerSetIds:[J

    .line 34581
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34585
    const v0, -0x676b4896

    return v0
.end method
