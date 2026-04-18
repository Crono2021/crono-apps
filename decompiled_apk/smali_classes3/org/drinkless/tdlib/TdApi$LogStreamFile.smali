.class public Lorg/drinkless/tdlib/TdApi$LogStreamFile;
.super Lorg/drinkless/tdlib/TdApi$LogStream;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LogStreamFile"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5b528de5


# instance fields
.field public maxFileSize:J

.field public path:Ljava/lang/String;

.field public redirectStderr:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38414
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LogStream;-><init>()V

    .line 38415
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JZ)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "z8"    # Z

    .line 38403
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LogStream;-><init>()V

    .line 38404
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LogStreamFile;->path:Ljava/lang/String;

    .line 38405
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$LogStreamFile;->maxFileSize:J

    .line 38406
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$LogStreamFile;->redirectStderr:Z

    .line 38407
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38411
    const v0, 0x5b528de5

    return v0
.end method
