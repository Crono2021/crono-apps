.class public Lorg/drinkless/tdlib/TdApi$LoginUrlInfoRequestConfirmation;
.super Lorg/drinkless/tdlib/TdApi$LoginUrlInfo;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LoginUrlInfoRequestConfirmation"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7edb242f


# instance fields
.field public botUserId:J

.field public domain:Ljava/lang/String;

.field public requestWriteAccess:Z

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44094
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LoginUrlInfo;-><init>()V

    .line 44095
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;JZ)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "j5"    # J
    .param p5, "z8"    # Z

    .line 44082
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LoginUrlInfo;-><init>()V

    .line 44083
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LoginUrlInfoRequestConfirmation;->url:Ljava/lang/String;

    .line 44084
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$LoginUrlInfoRequestConfirmation;->domain:Ljava/lang/String;

    .line 44085
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$LoginUrlInfoRequestConfirmation;->botUserId:J

    .line 44086
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$LoginUrlInfoRequestConfirmation;->requestWriteAccess:Z

    .line 44087
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44091
    const v0, 0x7edb242f

    return v0
.end method
