.class public Lorg/drinkless/tdlib/TdApi$UpdateSavedMessagesTopic;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateSavedMessagesTopic"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x607dc4d0


# instance fields
.field public topic:Lorg/drinkless/tdlib/TdApi$SavedMessagesTopic;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22052
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 22053
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$SavedMessagesTopic;)V
    .locals 0
    .param p1, "savedMessagesTopic"    # Lorg/drinkless/tdlib/TdApi$SavedMessagesTopic;

    .line 22043
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 22044
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateSavedMessagesTopic;->topic:Lorg/drinkless/tdlib/TdApi$SavedMessagesTopic;

    .line 22045
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22049
    const v0, -0x607dc4d0

    return v0
.end method
