.class public final Landroidx/media3/common/Format$Builder;
.super Ljava/lang/Object;
.source "Format.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/common/Format;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation


# instance fields
.field private accessibilityChannel:I

.field private averageBitrate:I

.field private channelCount:I

.field private codecs:Ljava/lang/String;

.field private colorInfo:Landroidx/media3/common/ColorInfo;

.field private containerMimeType:Ljava/lang/String;

.field private cryptoType:I

.field private cueReplacementBehavior:I

.field private drmInitData:Landroidx/media3/common/DrmInitData;

.field private encoderDelay:I

.field private encoderPadding:I

.field private frameRate:F

.field private height:I

.field private id:Ljava/lang/String;

.field private initializationData:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "[B>;"
        }
    .end annotation
.end field

.field private label:Ljava/lang/String;

.field private labels:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Landroidx/media3/common/Label;",
            ">;"
        }
    .end annotation
.end field

.field private language:Ljava/lang/String;

.field private maxInputSize:I

.field private metadata:Landroidx/media3/common/Metadata;

.field private pcmEncoding:I

.field private peakBitrate:I

.field private pixelWidthHeightRatio:F

.field private projectionData:[B

.field private roleFlags:I

.field private rotationDegrees:I

.field private sampleMimeType:Ljava/lang/String;

.field private sampleRate:I

.field private selectionFlags:I

.field private stereoMode:I

.field private subsampleOffsetUs:J

.field private tileCountHorizontal:I

.field private tileCountVertical:I

.field private width:I


# direct methods
.method public constructor <init>()V
    .locals 3

    .line 199
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 200
    invoke-static {}, Lcom/google/common/collect/ImmutableList;->of()Lcom/google/common/collect/ImmutableList;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/common/Format$Builder;->labels:Ljava/util/List;

    .line 201
    const/4 v0, -0x1

    iput v0, p0, Landroidx/media3/common/Format$Builder;->averageBitrate:I

    .line 202
    iput v0, p0, Landroidx/media3/common/Format$Builder;->peakBitrate:I

    .line 204
    iput v0, p0, Landroidx/media3/common/Format$Builder;->maxInputSize:I

    .line 205
    const-wide v1, 0x7fffffffffffffffL

    iput-wide v1, p0, Landroidx/media3/common/Format$Builder;->subsampleOffsetUs:J

    .line 207
    iput v0, p0, Landroidx/media3/common/Format$Builder;->width:I

    .line 208
    iput v0, p0, Landroidx/media3/common/Format$Builder;->height:I

    .line 209
    const/high16 v1, -0x40800000    # -1.0f

    iput v1, p0, Landroidx/media3/common/Format$Builder;->frameRate:F

    .line 210
    const/high16 v1, 0x3f800000    # 1.0f

    iput v1, p0, Landroidx/media3/common/Format$Builder;->pixelWidthHeightRatio:F

    .line 211
    iput v0, p0, Landroidx/media3/common/Format$Builder;->stereoMode:I

    .line 213
    iput v0, p0, Landroidx/media3/common/Format$Builder;->channelCount:I

    .line 214
    iput v0, p0, Landroidx/media3/common/Format$Builder;->sampleRate:I

    .line 215
    iput v0, p0, Landroidx/media3/common/Format$Builder;->pcmEncoding:I

    .line 217
    iput v0, p0, Landroidx/media3/common/Format$Builder;->accessibilityChannel:I

    .line 218
    const/4 v1, 0x1

    iput v1, p0, Landroidx/media3/common/Format$Builder;->cueReplacementBehavior:I

    .line 220
    iput v0, p0, Landroidx/media3/common/Format$Builder;->tileCountHorizontal:I

    .line 221
    iput v0, p0, Landroidx/media3/common/Format$Builder;->tileCountVertical:I

    .line 223
    const/4 v0, 0x0

    iput v0, p0, Landroidx/media3/common/Format$Builder;->cryptoType:I

    .line 224
    return-void
.end method

.method private constructor <init>(Landroidx/media3/common/Format;)V
    .locals 2
    .param p1, "format"    # Landroidx/media3/common/Format;

    .line 231
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 232
    iget-object v0, p1, Landroidx/media3/common/Format;->id:Ljava/lang/String;

    iput-object v0, p0, Landroidx/media3/common/Format$Builder;->id:Ljava/lang/String;

    .line 233
    iget-object v0, p1, Landroidx/media3/common/Format;->label:Ljava/lang/String;

    iput-object v0, p0, Landroidx/media3/common/Format$Builder;->label:Ljava/lang/String;

    .line 234
    iget-object v0, p1, Landroidx/media3/common/Format;->labels:Ljava/util/List;

    iput-object v0, p0, Landroidx/media3/common/Format$Builder;->labels:Ljava/util/List;

    .line 235
    iget-object v0, p1, Landroidx/media3/common/Format;->language:Ljava/lang/String;

    iput-object v0, p0, Landroidx/media3/common/Format$Builder;->language:Ljava/lang/String;

    .line 236
    iget v0, p1, Landroidx/media3/common/Format;->selectionFlags:I

    iput v0, p0, Landroidx/media3/common/Format$Builder;->selectionFlags:I

    .line 237
    iget v0, p1, Landroidx/media3/common/Format;->roleFlags:I

    iput v0, p0, Landroidx/media3/common/Format$Builder;->roleFlags:I

    .line 238
    iget v0, p1, Landroidx/media3/common/Format;->averageBitrate:I

    iput v0, p0, Landroidx/media3/common/Format$Builder;->averageBitrate:I

    .line 239
    iget v0, p1, Landroidx/media3/common/Format;->peakBitrate:I

    iput v0, p0, Landroidx/media3/common/Format$Builder;->peakBitrate:I

    .line 240
    iget-object v0, p1, Landroidx/media3/common/Format;->codecs:Ljava/lang/String;

    iput-object v0, p0, Landroidx/media3/common/Format$Builder;->codecs:Ljava/lang/String;

    .line 241
    iget-object v0, p1, Landroidx/media3/common/Format;->metadata:Landroidx/media3/common/Metadata;

    iput-object v0, p0, Landroidx/media3/common/Format$Builder;->metadata:Landroidx/media3/common/Metadata;

    .line 243
    iget-object v0, p1, Landroidx/media3/common/Format;->containerMimeType:Ljava/lang/String;

    iput-object v0, p0, Landroidx/media3/common/Format$Builder;->containerMimeType:Ljava/lang/String;

    .line 245
    iget-object v0, p1, Landroidx/media3/common/Format;->sampleMimeType:Ljava/lang/String;

    iput-object v0, p0, Landroidx/media3/common/Format$Builder;->sampleMimeType:Ljava/lang/String;

    .line 246
    iget v0, p1, Landroidx/media3/common/Format;->maxInputSize:I

    iput v0, p0, Landroidx/media3/common/Format$Builder;->maxInputSize:I

    .line 247
    iget-object v0, p1, Landroidx/media3/common/Format;->initializationData:Ljava/util/List;

    iput-object v0, p0, Landroidx/media3/common/Format$Builder;->initializationData:Ljava/util/List;

    .line 248
    iget-object v0, p1, Landroidx/media3/common/Format;->drmInitData:Landroidx/media3/common/DrmInitData;

    iput-object v0, p0, Landroidx/media3/common/Format$Builder;->drmInitData:Landroidx/media3/common/DrmInitData;

    .line 249
    iget-wide v0, p1, Landroidx/media3/common/Format;->subsampleOffsetUs:J

    iput-wide v0, p0, Landroidx/media3/common/Format$Builder;->subsampleOffsetUs:J

    .line 251
    iget v0, p1, Landroidx/media3/common/Format;->width:I

    iput v0, p0, Landroidx/media3/common/Format$Builder;->width:I

    .line 252
    iget v0, p1, Landroidx/media3/common/Format;->height:I

    iput v0, p0, Landroidx/media3/common/Format$Builder;->height:I

    .line 253
    iget v0, p1, Landroidx/media3/common/Format;->frameRate:F

    iput v0, p0, Landroidx/media3/common/Format$Builder;->frameRate:F

    .line 254
    iget v0, p1, Landroidx/media3/common/Format;->rotationDegrees:I

    iput v0, p0, Landroidx/media3/common/Format$Builder;->rotationDegrees:I

    .line 255
    iget v0, p1, Landroidx/media3/common/Format;->pixelWidthHeightRatio:F

    iput v0, p0, Landroidx/media3/common/Format$Builder;->pixelWidthHeightRatio:F

    .line 256
    iget-object v0, p1, Landroidx/media3/common/Format;->projectionData:[B

    iput-object v0, p0, Landroidx/media3/common/Format$Builder;->projectionData:[B

    .line 257
    iget v0, p1, Landroidx/media3/common/Format;->stereoMode:I

    iput v0, p0, Landroidx/media3/common/Format$Builder;->stereoMode:I

    .line 258
    iget-object v0, p1, Landroidx/media3/common/Format;->colorInfo:Landroidx/media3/common/ColorInfo;

    iput-object v0, p0, Landroidx/media3/common/Format$Builder;->colorInfo:Landroidx/media3/common/ColorInfo;

    .line 260
    iget v0, p1, Landroidx/media3/common/Format;->channelCount:I

    iput v0, p0, Landroidx/media3/common/Format$Builder;->channelCount:I

    .line 261
    iget v0, p1, Landroidx/media3/common/Format;->sampleRate:I

    iput v0, p0, Landroidx/media3/common/Format$Builder;->sampleRate:I

    .line 262
    iget v0, p1, Landroidx/media3/common/Format;->pcmEncoding:I

    iput v0, p0, Landroidx/media3/common/Format$Builder;->pcmEncoding:I

    .line 263
    iget v0, p1, Landroidx/media3/common/Format;->encoderDelay:I

    iput v0, p0, Landroidx/media3/common/Format$Builder;->encoderDelay:I

    .line 264
    iget v0, p1, Landroidx/media3/common/Format;->encoderPadding:I

    iput v0, p0, Landroidx/media3/common/Format$Builder;->encoderPadding:I

    .line 266
    iget v0, p1, Landroidx/media3/common/Format;->accessibilityChannel:I

    iput v0, p0, Landroidx/media3/common/Format$Builder;->accessibilityChannel:I

    .line 267
    iget v0, p1, Landroidx/media3/common/Format;->cueReplacementBehavior:I

    iput v0, p0, Landroidx/media3/common/Format$Builder;->cueReplacementBehavior:I

    .line 269
    iget v0, p1, Landroidx/media3/common/Format;->tileCountHorizontal:I

    iput v0, p0, Landroidx/media3/common/Format$Builder;->tileCountHorizontal:I

    .line 270
    iget v0, p1, Landroidx/media3/common/Format;->tileCountVertical:I

    iput v0, p0, Landroidx/media3/common/Format$Builder;->tileCountVertical:I

    .line 272
    iget v0, p1, Landroidx/media3/common/Format;->cryptoType:I

    iput v0, p0, Landroidx/media3/common/Format$Builder;->cryptoType:I

    .line 273
    return-void
.end method

.method synthetic constructor <init>(Landroidx/media3/common/Format;Landroidx/media3/common/Format$1;)V
    .locals 0
    .param p1, "x0"    # Landroidx/media3/common/Format;
    .param p2, "x1"    # Landroidx/media3/common/Format$1;

    .line 140
    invoke-direct {p0, p1}, Landroidx/media3/common/Format$Builder;-><init>(Landroidx/media3/common/Format;)V

    return-void
.end method

.method static synthetic access$100(Landroidx/media3/common/Format$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget-object v0, p0, Landroidx/media3/common/Format$Builder;->id:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1000(Landroidx/media3/common/Format$Builder;)Landroidx/media3/common/Metadata;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget-object v0, p0, Landroidx/media3/common/Format$Builder;->metadata:Landroidx/media3/common/Metadata;

    return-object v0
.end method

.method static synthetic access$1100(Landroidx/media3/common/Format$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget-object v0, p0, Landroidx/media3/common/Format$Builder;->containerMimeType:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1200(Landroidx/media3/common/Format$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget-object v0, p0, Landroidx/media3/common/Format$Builder;->sampleMimeType:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1300(Landroidx/media3/common/Format$Builder;)I
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget v0, p0, Landroidx/media3/common/Format$Builder;->maxInputSize:I

    return v0
.end method

.method static synthetic access$1400(Landroidx/media3/common/Format$Builder;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget-object v0, p0, Landroidx/media3/common/Format$Builder;->initializationData:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$1500(Landroidx/media3/common/Format$Builder;)Landroidx/media3/common/DrmInitData;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget-object v0, p0, Landroidx/media3/common/Format$Builder;->drmInitData:Landroidx/media3/common/DrmInitData;

    return-object v0
.end method

.method static synthetic access$1600(Landroidx/media3/common/Format$Builder;)J
    .locals 2
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget-wide v0, p0, Landroidx/media3/common/Format$Builder;->subsampleOffsetUs:J

    return-wide v0
.end method

.method static synthetic access$1700(Landroidx/media3/common/Format$Builder;)I
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget v0, p0, Landroidx/media3/common/Format$Builder;->width:I

    return v0
.end method

.method static synthetic access$1800(Landroidx/media3/common/Format$Builder;)I
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget v0, p0, Landroidx/media3/common/Format$Builder;->height:I

    return v0
.end method

.method static synthetic access$1900(Landroidx/media3/common/Format$Builder;)F
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget v0, p0, Landroidx/media3/common/Format$Builder;->frameRate:F

    return v0
.end method

.method static synthetic access$200(Landroidx/media3/common/Format$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget-object v0, p0, Landroidx/media3/common/Format$Builder;->language:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$2000(Landroidx/media3/common/Format$Builder;)I
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget v0, p0, Landroidx/media3/common/Format$Builder;->rotationDegrees:I

    return v0
.end method

.method static synthetic access$2100(Landroidx/media3/common/Format$Builder;)F
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget v0, p0, Landroidx/media3/common/Format$Builder;->pixelWidthHeightRatio:F

    return v0
.end method

.method static synthetic access$2200(Landroidx/media3/common/Format$Builder;)[B
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget-object v0, p0, Landroidx/media3/common/Format$Builder;->projectionData:[B

    return-object v0
.end method

.method static synthetic access$2300(Landroidx/media3/common/Format$Builder;)I
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget v0, p0, Landroidx/media3/common/Format$Builder;->stereoMode:I

    return v0
.end method

.method static synthetic access$2400(Landroidx/media3/common/Format$Builder;)Landroidx/media3/common/ColorInfo;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget-object v0, p0, Landroidx/media3/common/Format$Builder;->colorInfo:Landroidx/media3/common/ColorInfo;

    return-object v0
.end method

.method static synthetic access$2500(Landroidx/media3/common/Format$Builder;)I
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget v0, p0, Landroidx/media3/common/Format$Builder;->channelCount:I

    return v0
.end method

.method static synthetic access$2600(Landroidx/media3/common/Format$Builder;)I
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget v0, p0, Landroidx/media3/common/Format$Builder;->sampleRate:I

    return v0
.end method

.method static synthetic access$2700(Landroidx/media3/common/Format$Builder;)I
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget v0, p0, Landroidx/media3/common/Format$Builder;->pcmEncoding:I

    return v0
.end method

.method static synthetic access$2800(Landroidx/media3/common/Format$Builder;)I
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget v0, p0, Landroidx/media3/common/Format$Builder;->encoderDelay:I

    return v0
.end method

.method static synthetic access$2900(Landroidx/media3/common/Format$Builder;)I
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget v0, p0, Landroidx/media3/common/Format$Builder;->encoderPadding:I

    return v0
.end method

.method static synthetic access$300(Landroidx/media3/common/Format$Builder;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget-object v0, p0, Landroidx/media3/common/Format$Builder;->labels:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$3000(Landroidx/media3/common/Format$Builder;)I
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget v0, p0, Landroidx/media3/common/Format$Builder;->accessibilityChannel:I

    return v0
.end method

.method static synthetic access$3100(Landroidx/media3/common/Format$Builder;)I
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget v0, p0, Landroidx/media3/common/Format$Builder;->cueReplacementBehavior:I

    return v0
.end method

.method static synthetic access$3200(Landroidx/media3/common/Format$Builder;)I
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget v0, p0, Landroidx/media3/common/Format$Builder;->tileCountHorizontal:I

    return v0
.end method

.method static synthetic access$3300(Landroidx/media3/common/Format$Builder;)I
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget v0, p0, Landroidx/media3/common/Format$Builder;->tileCountVertical:I

    return v0
.end method

.method static synthetic access$3400(Landroidx/media3/common/Format$Builder;)I
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget v0, p0, Landroidx/media3/common/Format$Builder;->cryptoType:I

    return v0
.end method

.method static synthetic access$400(Landroidx/media3/common/Format$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget-object v0, p0, Landroidx/media3/common/Format$Builder;->label:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$500(Landroidx/media3/common/Format$Builder;)I
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget v0, p0, Landroidx/media3/common/Format$Builder;->selectionFlags:I

    return v0
.end method

.method static synthetic access$600(Landroidx/media3/common/Format$Builder;)I
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget v0, p0, Landroidx/media3/common/Format$Builder;->roleFlags:I

    return v0
.end method

.method static synthetic access$700(Landroidx/media3/common/Format$Builder;)I
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget v0, p0, Landroidx/media3/common/Format$Builder;->averageBitrate:I

    return v0
.end method

.method static synthetic access$800(Landroidx/media3/common/Format$Builder;)I
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget v0, p0, Landroidx/media3/common/Format$Builder;->peakBitrate:I

    return v0
.end method

.method static synthetic access$900(Landroidx/media3/common/Format$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/Format$Builder;

    .line 140
    iget-object v0, p0, Landroidx/media3/common/Format$Builder;->codecs:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public build()Landroidx/media3/common/Format;
    .locals 2

    .line 720
    new-instance v0, Landroidx/media3/common/Format;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Landroidx/media3/common/Format;-><init>(Landroidx/media3/common/Format$Builder;Landroidx/media3/common/Format$1;)V

    return-object v0
.end method

.method public setAccessibilityChannel(I)Landroidx/media3/common/Format$Builder;
    .locals 0
    .param p1, "accessibilityChannel"    # I

    .line 660
    iput p1, p0, Landroidx/media3/common/Format$Builder;->accessibilityChannel:I

    .line 661
    return-object p0
.end method

.method public setAverageBitrate(I)Landroidx/media3/common/Format$Builder;
    .locals 0
    .param p1, "averageBitrate"    # I

    .line 374
    iput p1, p0, Landroidx/media3/common/Format$Builder;->averageBitrate:I

    .line 375
    return-object p0
.end method

.method public setChannelCount(I)Landroidx/media3/common/Format$Builder;
    .locals 0
    .param p1, "channelCount"    # I

    .line 598
    iput p1, p0, Landroidx/media3/common/Format$Builder;->channelCount:I

    .line 599
    return-object p0
.end method

.method public setCodecs(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;
    .locals 0
    .param p1, "codecs"    # Ljava/lang/String;

    .line 398
    iput-object p1, p0, Landroidx/media3/common/Format$Builder;->codecs:Ljava/lang/String;

    .line 399
    return-object p0
.end method

.method public setColorInfo(Landroidx/media3/common/ColorInfo;)Landroidx/media3/common/Format$Builder;
    .locals 0
    .param p1, "colorInfo"    # Landroidx/media3/common/ColorInfo;

    .line 584
    iput-object p1, p0, Landroidx/media3/common/Format$Builder;->colorInfo:Landroidx/media3/common/ColorInfo;

    .line 585
    return-object p0
.end method

.method public setContainerMimeType(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;
    .locals 1
    .param p1, "containerMimeType"    # Ljava/lang/String;

    .line 424
    invoke-static {p1}, Landroidx/media3/common/MimeTypes;->normalizeMimeType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/common/Format$Builder;->containerMimeType:Ljava/lang/String;

    .line 425
    return-object p0
.end method

.method public setCryptoType(I)Landroidx/media3/common/Format$Builder;
    .locals 0
    .param p1, "cryptoType"    # I

    .line 713
    iput p1, p0, Landroidx/media3/common/Format$Builder;->cryptoType:I

    .line 714
    return-object p0
.end method

.method public setCueReplacementBehavior(I)Landroidx/media3/common/Format$Builder;
    .locals 0
    .param p1, "cueReplacementBehavior"    # I

    .line 673
    iput p1, p0, Landroidx/media3/common/Format$Builder;->cueReplacementBehavior:I

    .line 674
    return-object p0
.end method

.method public setDrmInitData(Landroidx/media3/common/DrmInitData;)Landroidx/media3/common/Format$Builder;
    .locals 0
    .param p1, "drmInitData"    # Landroidx/media3/common/DrmInitData;

    .line 474
    iput-object p1, p0, Landroidx/media3/common/Format$Builder;->drmInitData:Landroidx/media3/common/DrmInitData;

    .line 475
    return-object p0
.end method

.method public setEncoderDelay(I)Landroidx/media3/common/Format$Builder;
    .locals 0
    .param p1, "encoderDelay"    # I

    .line 634
    iput p1, p0, Landroidx/media3/common/Format$Builder;->encoderDelay:I

    .line 635
    return-object p0
.end method

.method public setEncoderPadding(I)Landroidx/media3/common/Format$Builder;
    .locals 0
    .param p1, "encoderPadding"    # I

    .line 646
    iput p1, p0, Landroidx/media3/common/Format$Builder;->encoderPadding:I

    .line 647
    return-object p0
.end method

.method public setFrameRate(F)Landroidx/media3/common/Format$Builder;
    .locals 0
    .param p1, "frameRate"    # F

    .line 524
    iput p1, p0, Landroidx/media3/common/Format$Builder;->frameRate:F

    .line 525
    return-object p0
.end method

.method public setHeight(I)Landroidx/media3/common/Format$Builder;
    .locals 0
    .param p1, "height"    # I

    .line 512
    iput p1, p0, Landroidx/media3/common/Format$Builder;->height:I

    .line 513
    return-object p0
.end method

.method public setId(I)Landroidx/media3/common/Format$Builder;
    .locals 1
    .param p1, "id"    # I

    .line 296
    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/common/Format$Builder;->id:Ljava/lang/String;

    .line 297
    return-object p0
.end method

.method public setId(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .line 283
    iput-object p1, p0, Landroidx/media3/common/Format$Builder;->id:Ljava/lang/String;

    .line 284
    return-object p0
.end method

.method public setInitializationData(Ljava/util/List;)Landroidx/media3/common/Format$Builder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "[B>;)",
            "Landroidx/media3/common/Format$Builder;"
        }
    .end annotation

    .line 462
    .local p1, "initializationData":Ljava/util/List;, "Ljava/util/List<[B>;"
    iput-object p1, p0, Landroidx/media3/common/Format$Builder;->initializationData:Ljava/util/List;

    .line 463
    return-object p0
.end method

.method public setLabel(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;
    .locals 0
    .param p1, "label"    # Ljava/lang/String;

    .line 311
    iput-object p1, p0, Landroidx/media3/common/Format$Builder;->label:Ljava/lang/String;

    .line 312
    return-object p0
.end method

.method public setLabels(Ljava/util/List;)Landroidx/media3/common/Format$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Landroidx/media3/common/Label;",
            ">;)",
            "Landroidx/media3/common/Format$Builder;"
        }
    .end annotation

    .line 326
    .local p1, "labels":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/common/Label;>;"
    invoke-static {p1}, Lcom/google/common/collect/ImmutableList;->copyOf(Ljava/util/Collection;)Lcom/google/common/collect/ImmutableList;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/common/Format$Builder;->labels:Ljava/util/List;

    .line 327
    return-object p0
.end method

.method public setLanguage(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;
    .locals 0
    .param p1, "language"    # Ljava/lang/String;

    .line 338
    iput-object p1, p0, Landroidx/media3/common/Format$Builder;->language:Ljava/lang/String;

    .line 339
    return-object p0
.end method

.method public setMaxInputSize(I)Landroidx/media3/common/Format$Builder;
    .locals 0
    .param p1, "maxInputSize"    # I

    .line 450
    iput p1, p0, Landroidx/media3/common/Format$Builder;->maxInputSize:I

    .line 451
    return-object p0
.end method

.method public setMetadata(Landroidx/media3/common/Metadata;)Landroidx/media3/common/Format$Builder;
    .locals 0
    .param p1, "metadata"    # Landroidx/media3/common/Metadata;

    .line 410
    iput-object p1, p0, Landroidx/media3/common/Format$Builder;->metadata:Landroidx/media3/common/Metadata;

    .line 411
    return-object p0
.end method

.method public setPcmEncoding(I)Landroidx/media3/common/Format$Builder;
    .locals 0
    .param p1, "pcmEncoding"    # I

    .line 622
    iput p1, p0, Landroidx/media3/common/Format$Builder;->pcmEncoding:I

    .line 623
    return-object p0
.end method

.method public setPeakBitrate(I)Landroidx/media3/common/Format$Builder;
    .locals 0
    .param p1, "peakBitrate"    # I

    .line 386
    iput p1, p0, Landroidx/media3/common/Format$Builder;->peakBitrate:I

    .line 387
    return-object p0
.end method

.method public setPixelWidthHeightRatio(F)Landroidx/media3/common/Format$Builder;
    .locals 0
    .param p1, "pixelWidthHeightRatio"    # F

    .line 548
    iput p1, p0, Landroidx/media3/common/Format$Builder;->pixelWidthHeightRatio:F

    .line 549
    return-object p0
.end method

.method public setProjectionData([B)Landroidx/media3/common/Format$Builder;
    .locals 0
    .param p1, "projectionData"    # [B

    .line 560
    iput-object p1, p0, Landroidx/media3/common/Format$Builder;->projectionData:[B

    .line 561
    return-object p0
.end method

.method public setRoleFlags(I)Landroidx/media3/common/Format$Builder;
    .locals 0
    .param p1, "roleFlags"    # I

    .line 362
    iput p1, p0, Landroidx/media3/common/Format$Builder;->roleFlags:I

    .line 363
    return-object p0
.end method

.method public setRotationDegrees(I)Landroidx/media3/common/Format$Builder;
    .locals 0
    .param p1, "rotationDegrees"    # I

    .line 536
    iput p1, p0, Landroidx/media3/common/Format$Builder;->rotationDegrees:I

    .line 537
    return-object p0
.end method

.method public setSampleMimeType(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;
    .locals 1
    .param p1, "sampleMimeType"    # Ljava/lang/String;

    .line 438
    invoke-static {p1}, Landroidx/media3/common/MimeTypes;->normalizeMimeType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/common/Format$Builder;->sampleMimeType:Ljava/lang/String;

    .line 439
    return-object p0
.end method

.method public setSampleRate(I)Landroidx/media3/common/Format$Builder;
    .locals 0
    .param p1, "sampleRate"    # I

    .line 610
    iput p1, p0, Landroidx/media3/common/Format$Builder;->sampleRate:I

    .line 611
    return-object p0
.end method

.method public setSelectionFlags(I)Landroidx/media3/common/Format$Builder;
    .locals 0
    .param p1, "selectionFlags"    # I

    .line 350
    iput p1, p0, Landroidx/media3/common/Format$Builder;->selectionFlags:I

    .line 351
    return-object p0
.end method

.method public setStereoMode(I)Landroidx/media3/common/Format$Builder;
    .locals 0
    .param p1, "stereoMode"    # I

    .line 572
    iput p1, p0, Landroidx/media3/common/Format$Builder;->stereoMode:I

    .line 573
    return-object p0
.end method

.method public setSubsampleOffsetUs(J)Landroidx/media3/common/Format$Builder;
    .locals 0
    .param p1, "subsampleOffsetUs"    # J

    .line 486
    iput-wide p1, p0, Landroidx/media3/common/Format$Builder;->subsampleOffsetUs:J

    .line 487
    return-object p0
.end method

.method public setTileCountHorizontal(I)Landroidx/media3/common/Format$Builder;
    .locals 0
    .param p1, "tileCountHorizontal"    # I

    .line 687
    iput p1, p0, Landroidx/media3/common/Format$Builder;->tileCountHorizontal:I

    .line 688
    return-object p0
.end method

.method public setTileCountVertical(I)Landroidx/media3/common/Format$Builder;
    .locals 0
    .param p1, "tileCountVertical"    # I

    .line 699
    iput p1, p0, Landroidx/media3/common/Format$Builder;->tileCountVertical:I

    .line 700
    return-object p0
.end method

.method public setWidth(I)Landroidx/media3/common/Format$Builder;
    .locals 0
    .param p1, "width"    # I

    .line 500
    iput p1, p0, Landroidx/media3/common/Format$Builder;->width:I

    .line 501
    return-object p0
.end method
