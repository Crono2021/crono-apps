.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypeGroupCall;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypeGroupCall"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7469b416


# instance fields
.field public inviteLink:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15342
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15343
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 15333
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15334
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeGroupCall;->inviteLink:Ljava/lang/String;

    .line 15335
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15339
    const v0, 0x7469b416

    return v0
.end method
