.class public Lorg/drinkless/tdlib/TdApi$ChatEventAccentColorChanged;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventAccentColorChanged"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x197c88cd


# instance fields
.field public newAccentColorId:I

.field public newBackgroundCustomEmojiId:J

.field public oldAccentColorId:I

.field public oldBackgroundCustomEmojiId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42702
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 42703
    return-void
.end method

.method public constructor <init>(IJIJ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "j5"    # J
    .param p4, "i10"    # I
    .param p5, "j9"    # J

    .line 42690
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 42691
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventAccentColorChanged;->oldAccentColorId:I

    .line 42692
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$ChatEventAccentColorChanged;->oldBackgroundCustomEmojiId:J

    .line 42693
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$ChatEventAccentColorChanged;->newAccentColorId:I

    .line 42694
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$ChatEventAccentColorChanged;->newBackgroundCustomEmojiId:J

    .line 42695
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42699
    const v0, -0x197c88cd

    return v0
.end method
