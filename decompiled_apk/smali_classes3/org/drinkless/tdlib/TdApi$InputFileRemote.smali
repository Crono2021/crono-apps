.class public Lorg/drinkless/tdlib/TdApi$InputFileRemote;
.super Lorg/drinkless/tdlib/TdApi$InputFile;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputFileRemote"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x66974c2


# instance fields
.field public id:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14658
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputFile;-><init>()V

    .line 14659
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 14649
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputFile;-><init>()V

    .line 14650
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputFileRemote;->id:Ljava/lang/String;

    .line 14651
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14655
    const v0, -0x66974c2

    return v0
.end method
