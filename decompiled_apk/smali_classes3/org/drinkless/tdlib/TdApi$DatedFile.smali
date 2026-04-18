.class public Lorg/drinkless/tdlib/TdApi$DatedFile;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DatedFile"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6db84f63


# instance fields
.field public date:I

.field public file:Lorg/drinkless/tdlib/TdApi$File;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24824
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24825
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$File;I)V
    .locals 0
    .param p1, "file"    # Lorg/drinkless/tdlib/TdApi$File;
    .param p2, "i9"    # I

    .line 24814
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24815
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$DatedFile;->file:Lorg/drinkless/tdlib/TdApi$File;

    .line 24816
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$DatedFile;->date:I

    .line 24817
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24821
    const v0, -0x6db84f63

    return v0
.end method
