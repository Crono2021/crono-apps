.class public Lorg/drinkless/tdlib/TdApi$ChatAdministrator;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatAdministrator"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7277bd2c


# instance fields
.field public customTitle:Ljava/lang/String;

.field public isOwner:Z

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36014
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 36015
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Z)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "z8"    # Z

    .line 36003
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 36004
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ChatAdministrator;->userId:J

    .line 36005
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ChatAdministrator;->customTitle:Ljava/lang/String;

    .line 36006
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$ChatAdministrator;->isOwner:Z

    .line 36007
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36011
    const v0, 0x7277bd2c

    return v0
.end method
