.class public Lorg/drinkless/tdlib/TdApi$ChatEventCustomEmojiStickerSetChanged;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventCustomEmojiStickerSetChanged"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x70c431b


# instance fields
.field public newStickerSetId:J

.field public oldStickerSetId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23724
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 23725
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 23714
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 23715
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventCustomEmojiStickerSetChanged;->oldStickerSetId:J

    .line 23716
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$ChatEventCustomEmojiStickerSetChanged;->newStickerSetId:J

    .line 23717
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23721
    const v0, 0x70c431b

    return v0
.end method
