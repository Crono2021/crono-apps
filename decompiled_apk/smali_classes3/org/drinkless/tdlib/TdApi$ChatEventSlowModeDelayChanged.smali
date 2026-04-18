.class public Lorg/drinkless/tdlib/TdApi$ChatEventSlowModeDelayChanged;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventSlowModeDelayChanged"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6289c3f5


# instance fields
.field public newSlowModeDelay:I

.field public oldSlowModeDelay:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24044
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 24045
    return-void
.end method

.method public constructor <init>(II)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I

    .line 24034
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 24035
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventSlowModeDelayChanged;->oldSlowModeDelay:I

    .line 24036
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$ChatEventSlowModeDelayChanged;->newSlowModeDelay:I

    .line 24037
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24041
    const v0, -0x6289c3f5

    return v0
.end method
