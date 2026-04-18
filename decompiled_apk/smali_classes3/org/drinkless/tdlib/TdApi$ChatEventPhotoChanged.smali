.class public Lorg/drinkless/tdlib/TdApi$ChatEventPhotoChanged;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventPhotoChanged"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x305f9d3d


# instance fields
.field public newPhoto:Lorg/drinkless/tdlib/TdApi$ChatPhoto;

.field public oldPhoto:Lorg/drinkless/tdlib/TdApi$ChatPhoto;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24024
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 24025
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatPhoto;Lorg/drinkless/tdlib/TdApi$ChatPhoto;)V
    .locals 0
    .param p1, "chatPhoto"    # Lorg/drinkless/tdlib/TdApi$ChatPhoto;
    .param p2, "chatPhoto2"    # Lorg/drinkless/tdlib/TdApi$ChatPhoto;

    .line 24014
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 24015
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventPhotoChanged;->oldPhoto:Lorg/drinkless/tdlib/TdApi$ChatPhoto;

    .line 24016
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChatEventPhotoChanged;->newPhoto:Lorg/drinkless/tdlib/TdApi$ChatPhoto;

    .line 24017
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24021
    const v0, -0x305f9d3d

    return v0
.end method
