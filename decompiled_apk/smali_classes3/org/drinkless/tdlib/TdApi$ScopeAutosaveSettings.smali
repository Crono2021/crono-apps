.class public Lorg/drinkless/tdlib/TdApi$ScopeAutosaveSettings;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ScopeAutosaveSettings"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5c329f33


# instance fields
.field public autosavePhotos:Z

.field public autosaveVideos:Z

.field public maxVideoFileSize:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39800
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 39801
    return-void
.end method

.method public constructor <init>(ZZJ)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "z9"    # Z
    .param p3, "j5"    # J

    .line 39789
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 39790
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$ScopeAutosaveSettings;->autosavePhotos:Z

    .line 39791
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$ScopeAutosaveSettings;->autosaveVideos:Z

    .line 39792
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$ScopeAutosaveSettings;->maxVideoFileSize:J

    .line 39793
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39797
    const v0, 0x5c329f33

    return v0
.end method
