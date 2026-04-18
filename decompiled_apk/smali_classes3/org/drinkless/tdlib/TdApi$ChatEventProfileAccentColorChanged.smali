.class public Lorg/drinkless/tdlib/TdApi$ChatEventProfileAccentColorChanged;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventProfileAccentColorChanged"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5a47259c


# instance fields
.field public newProfileAccentColorId:I

.field public newProfileBackgroundCustomEmojiId:J

.field public oldProfileAccentColorId:I

.field public oldProfileBackgroundCustomEmojiId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42726
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 42727
    return-void
.end method

.method public constructor <init>(IJIJ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "j5"    # J
    .param p4, "i10"    # I
    .param p5, "j9"    # J

    .line 42714
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 42715
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventProfileAccentColorChanged;->oldProfileAccentColorId:I

    .line 42716
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$ChatEventProfileAccentColorChanged;->oldProfileBackgroundCustomEmojiId:J

    .line 42717
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$ChatEventProfileAccentColorChanged;->newProfileAccentColorId:I

    .line 42718
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$ChatEventProfileAccentColorChanged;->newProfileBackgroundCustomEmojiId:J

    .line 42719
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42723
    const v0, -0x5a47259c

    return v0
.end method
