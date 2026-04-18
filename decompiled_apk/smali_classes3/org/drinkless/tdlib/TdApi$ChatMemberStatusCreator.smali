.class public Lorg/drinkless/tdlib/TdApi$ChatMemberStatusCreator;
.super Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatMemberStatusCreator"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x989b502


# instance fields
.field public customTitle:Ljava/lang/String;

.field public isAnonymous:Z

.field public isMember:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36234
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;-><init>()V

    .line 36235
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;ZZ)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z
    .param p3, "z9"    # Z

    .line 36223
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;-><init>()V

    .line 36224
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatMemberStatusCreator;->customTitle:Ljava/lang/String;

    .line 36225
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$ChatMemberStatusCreator;->isAnonymous:Z

    .line 36226
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ChatMemberStatusCreator;->isMember:Z

    .line 36227
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36231
    const v0, -0x989b502

    return v0
.end method
