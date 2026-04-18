.class public Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeUser;
.super Lorg/drinkless/tdlib/TdApi$LinkPreviewType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LinkPreviewTypeUser"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x57527e84


# instance fields
.field public isBot:Z

.field public photo:Lorg/drinkless/tdlib/TdApi$ChatPhoto;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28084
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 28085
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatPhoto;Z)V
    .locals 0
    .param p1, "chatPhoto"    # Lorg/drinkless/tdlib/TdApi$ChatPhoto;
    .param p2, "z8"    # Z

    .line 28074
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 28075
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeUser;->photo:Lorg/drinkless/tdlib/TdApi$ChatPhoto;

    .line 28076
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeUser;->isBot:Z

    .line 28077
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28081
    const v0, -0x57527e84

    return v0
.end method
