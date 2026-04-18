.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypeMainWebApp;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypeMainWebApp"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5ddf72e9


# instance fields
.field public botUsername:Ljava/lang/String;

.field public mode:Lorg/drinkless/tdlib/TdApi$WebAppOpenMode;

.field public startParameter:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38172
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 38173
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$WebAppOpenMode;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "webAppOpenMode"    # Lorg/drinkless/tdlib/TdApi$WebAppOpenMode;

    .line 38161
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 38162
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeMainWebApp;->botUsername:Ljava/lang/String;

    .line 38163
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeMainWebApp;->startParameter:Ljava/lang/String;

    .line 38164
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeMainWebApp;->mode:Lorg/drinkless/tdlib/TdApi$WebAppOpenMode;

    .line 38165
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38169
    const v0, 0x5ddf72e9

    return v0
.end method
