.class public Lorg/drinkless/tdlib/TdApi$ChatEventMessageAutoDeleteTimeChanged;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventMessageAutoDeleteTimeChanged"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1083f24


# instance fields
.field public newMessageAutoDeleteTime:I

.field public oldMessageAutoDeleteTime:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23944
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 23945
    return-void
.end method

.method public constructor <init>(II)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I

    .line 23934
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 23935
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventMessageAutoDeleteTimeChanged;->oldMessageAutoDeleteTime:I

    .line 23936
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$ChatEventMessageAutoDeleteTimeChanged;->newMessageAutoDeleteTime:I

    .line 23937
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23941
    const v0, 0x1083f24

    return v0
.end method
