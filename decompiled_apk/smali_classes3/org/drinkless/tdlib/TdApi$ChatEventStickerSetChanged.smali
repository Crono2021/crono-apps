.class public Lorg/drinkless/tdlib/TdApi$ChatEventStickerSetChanged;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventStickerSetChanged"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4a18aa71


# instance fields
.field public newStickerSetId:J

.field public oldStickerSetId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24064
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 24065
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 24054
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 24055
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventStickerSetChanged;->oldStickerSetId:J

    .line 24056
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$ChatEventStickerSetChanged;->newStickerSetId:J

    .line 24057
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24061
    const v0, -0x4a18aa71

    return v0
.end method
