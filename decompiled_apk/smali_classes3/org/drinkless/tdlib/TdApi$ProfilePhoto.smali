.class public Lorg/drinkless/tdlib/TdApi$ProfilePhoto;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ProfilePhoto"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3d23c3a2


# instance fields
.field public big:Lorg/drinkless/tdlib/TdApi$File;

.field public hasAnimation:Z

.field public id:J

.field public isPersonal:Z

.field public minithumbnail:Lorg/drinkless/tdlib/TdApi$Minithumbnail;

.field public small:Lorg/drinkless/tdlib/TdApi$File;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50514
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 50515
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$File;Lorg/drinkless/tdlib/TdApi$File;Lorg/drinkless/tdlib/TdApi$Minithumbnail;ZZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "file"    # Lorg/drinkless/tdlib/TdApi$File;
    .param p4, "file2"    # Lorg/drinkless/tdlib/TdApi$File;
    .param p5, "minithumbnail"    # Lorg/drinkless/tdlib/TdApi$Minithumbnail;
    .param p6, "z8"    # Z
    .param p7, "z9"    # Z

    .line 50500
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 50501
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ProfilePhoto;->id:J

    .line 50502
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ProfilePhoto;->small:Lorg/drinkless/tdlib/TdApi$File;

    .line 50503
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$ProfilePhoto;->big:Lorg/drinkless/tdlib/TdApi$File;

    .line 50504
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$ProfilePhoto;->minithumbnail:Lorg/drinkless/tdlib/TdApi$Minithumbnail;

    .line 50505
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$ProfilePhoto;->hasAnimation:Z

    .line 50506
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$ProfilePhoto;->isPersonal:Z

    .line 50507
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50511
    const v0, -0x3d23c3a2

    return v0
.end method
